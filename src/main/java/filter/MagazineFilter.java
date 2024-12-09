package filter;

import abstractDao.FilterService;
import jakarta.servlet.http.HttpServlet;

public class MagazineFilter extends HttpServlet {
    private FilterService filterService = FilterService.getFilterService();

//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        // Перевіряємо роль користувача перед доступом до сторінки
//        filterService.doFilterValidation(request, response, chain, Arrays.asList(UserRole.USER));
//    }
//
//    public void init(FilterConfig fConfig) throws ServletException {
//    }

}