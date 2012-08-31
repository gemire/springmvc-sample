
package com.dhenton9000.mule.security;

import java.util.Collection;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * This is a custom implementation of a UserDetails object to be used
 * for Mule Spring Security. The UserDetails service will fill this out
 * and it will be available to Mule UMOs via the security context
 * @author dhenton
 */
public class MyUserDetails implements UserDetails,CredentialsContainer {

    private User user = null;
    private String userFullName = null;

    public MyUserDetails(String username, String password, boolean enabled,
            boolean accountNonExpired, boolean credentialsNonExpired,
            boolean accountNonLocked, 
            GrantedAuthority[] authorities, String userFullName) {
        user = new User(username, password, enabled,
                accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
        
        this.userFullName = userFullName;

    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();

    }

    @Override
    public void eraseCredentials() {
        user.eraseCredentials();
    }

    /**
     * @return the userFullName this is an example of extra
     * information that can be added during the security 
     * lookup
     * 
     */
    public String getUserFullName() {
        return userFullName;
    }
    
    
}
