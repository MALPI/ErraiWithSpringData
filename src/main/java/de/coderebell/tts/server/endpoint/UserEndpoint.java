package de.coderebell.tts.server.endpoint;

import de.coderebell.tts.client.api.UserService;
import de.coderebell.tts.client.domain.User;
import de.coderebell.tts.server.dao.UserRepository;

import org.jboss.errai.bus.server.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by MALPI on 24.04.2014.
 */
@Service
@Stateless
public class UserEndpoint implements UserService{

    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserEndpoint.class);

    @Inject
    UserRepository userDao;

    @Transactional
    @Override
    public boolean registerNewUser(User user) {
        if (user == null) {
            LOGGER.error("Given user is null => Throwing exception");
            throw new IllegalArgumentException("Something went wrong");
        }

        if (user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is not set...");
        }

        LOGGER.debug("Creating new User: {}", user.toString());
        User existingUser = userDao.findUserByEmail(user.getEmail());
        if (existingUser != null) {
            LOGGER.info("Found an already existing User for that Email Adress, won't create a new one.");
            return false;
        } else {
            LOGGER.debug("Saving user {}", user.toString());
            try{
                user = (User) userDao.saveAndFlush(user);
            }catch(Exception e){
                LOGGER.error(e.toString());
                return false;
            }
            return user == null ? false : true;
        }
    }
}
