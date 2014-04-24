package de.coderebell.tts.client.api;

import de.coderebell.tts.client.domain.User;
import org.jboss.errai.bus.server.annotations.Remote;

/**
 * Created by MALPI on 24.04.2014.
 */
@Remote
public interface UserService {
    public boolean registerNewUser(User user);
}
