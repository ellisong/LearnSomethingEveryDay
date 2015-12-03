import com.lsed.jpa.Card;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "publishFilter", urlPatterns = { "*.xhtml" })
public class PublishFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            //HttpSession session = request.getSession(false);
            
            String cardIdString = request.getParameter("cardId");
            int cardId = 0;
            if (cardIdString != null)
                cardId = Integer.parseInt(cardIdString);
            
            int isPublished = 0;
            if (cardId > 0) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.lsed.LearnSomethingEveryDay");
                EntityManager em = emf.createEntityManager();
                TypedQuery query = em.createNamedQuery("Card.findByCardId", Card.class);
                query.setParameter("cardId", cardId);
                List<Card> results = query.getResultList();
                if (!results.isEmpty()) {
                    isPublished = results.get(0).getIsPublished();
                }
            }
            
            String viewcardURL = request.getContextPath() + "/viewcard.xhtml";
            boolean viewcardRequest = request.getRequestURI().startsWith(viewcardURL);
            if ((isPublished == 0) && viewcardRequest) {
                response.sendRedirect(request.getContextPath() + "/index.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        //      
    }
}
