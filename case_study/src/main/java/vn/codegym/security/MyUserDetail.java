package vn.codegym.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vn.codegym.model.Role;
import vn.codegym.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetail implements UserDetails {
    private User user;

    public MyUserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : user.getRole()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return grantedAuthorities;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return user.getPassWord();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNameEmployee(){
        return user.getEmployee().getEmployeeName();
    }
}
