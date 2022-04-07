package Filter;

import entity.Users;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        filterName = "authen_filter",
        urlPatterns = {
                "/*"
        }
)
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();
        Users user = (Users) session.getAttribute("auth");
//        if (user == null) {
////            httpServletResponse.sendRedirect("/Assignment_Java4_war/LoginControl");
//            return;
//        }
        chain.doFilter(request, response);
    }
}
