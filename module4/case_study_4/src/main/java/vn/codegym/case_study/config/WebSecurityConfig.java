package vn.codegym.case_study.config;

import vn.codegym.case_study.service.impl.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable(); //CSRF ( Cross Site Request Forgery) là kĩ thuật tấn công bằng cách sử dụng quyền chứng thực của người sử dụng đối với 1 website khác
//
//        // Các trang không yêu cầu login như vậy ai cũng có thể vào được admin hay user hoặc guest có thể vào các trang
//        http.authorizeRequests().antMatchers("/","/css/bootstrap.css", "/img/*", "/login", "/logout").permitAll()
//                .antMatchers("employee","/employee/create-employee").hasRole("ADMIN")
//                .antMatchers("/employee/edit").hasAnyRole("ADMIN", "USER")
//                .anyRequest().authenticated();
//        // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
//        // Nếu chưa login, nó sẽ redirect tới trang /login.sau Mình dung hasAnyRole để cho phép ai được quyền vào
//        // 2  ROLE_USER và ROLEADMIN thì ta lấy từ database ra cái mà mình chèn vô ở bước 1 (chuẩn bị database)
////        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
//
//        // Trang chỉ dành cho ADMIN
//        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
//
//        // Khi người dùng đã login, với vai trò user .
//        // Nhưng cố ý  truy cập vào trang admin
//        // Ngoại lệ AccessDeniedException sẽ ném ra.
//        // Ở đây mình tạo thêm một trang web lỗi tên 403.html (mọi người có thể tạo bất cứ tên nào khác)
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
//
//        // Cấu hình cho Login Form.
//        http.authorizeRequests().and().formLogin()//
//                // Submit URL của trang login
////                .loginProcessingUrl("/j_spring_security_check") // Bạn còn nhớ bước 3 khi tạo form login thì action của nó là j_spring_security_check giống ở
//                .loginPage("/login")//
//                .defaultSuccessUrl("/login/success")//đây Khi đăng nhập thành công thì vào trang này. userAccountInfo sẽ được khai báo trong controller để hiển thị trang view tương ứng
//                .failureUrl("/login?error=true")// Khi đăng nhật sai username và password thì nhập lại
//                .usernameParameter("username")// tham số này nhận từ form login ở bước 3 có input  name='username'
//                .passwordParameter("password")// tham số này nhận từ form login ở bước 3 có input  name='password'
//                // Cấu hình cho Logout Page. Khi logout mình trả về trang
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
//
//        // Cấu hình Remember Me . Ở form login bước 3, ta có 1 nút remember me. Nếu người dùng tick vào đó ta sẽ dung cookie lưu lại trong 24h
//
//        http.authorizeRequests().and() //
//                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
//                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h



        http.csrf().disable();

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        http
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()

                    .authorizeRequests().antMatchers("/","/css/bootstrap.css", "/img/*").permitAll()
                    .antMatchers("/employee/create-employee").hasRole("ADMIN")
                    .antMatchers("/service/create-service").hasRole("ADMIN")
                    .antMatchers("/customer/create-customer").hasRole("ADMIN")
                    .antMatchers("/contract/create-contract").hasRole("ADMIN")

                    .antMatchers("/employee/delete-employee").hasRole("ADMIN")
                    .antMatchers("/service/delete-service").hasRole("ADMIN")
                    .antMatchers("/customer/delete-customer").hasRole("ADMIN")
                    .antMatchers("/contract/delete-contract").hasRole("ADMIN")

                    .antMatchers("/employee/edit").hasAnyRole("ADMIN")
                    .antMatchers("/employee/view").hasAnyRole("ADMIN", "USER", "GUEST")
                    .anyRequest().authenticated()
                .and()
                    .logout().logoutUrl("/logout").logoutSuccessUrl("/");

        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(24 * 60 * 60);
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl(); // Ta lưu tạm remember me trong memory (RAM). Nếu cần mình có thể lưu trong database
        return memory;
    }

//        public static void main(String[] args) {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String pass = bCryptPasswordEncoder.encode("12345");
//        System.out.println(pass);
//    }
}
