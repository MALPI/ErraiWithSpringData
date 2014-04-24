package de.coderebell.tts.client.local;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.Label;
import de.coderebell.tts.client.api.UserService;
import de.coderebell.tts.client.domain.User;
import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.ErrorCallback;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;

@Page(role = DefaultPage.class)
@Templated(value="RegisterForm.html#form")
public class RegisterForm extends Composite {

    @Inject
    private Caller<UserService> userService;

	@Inject
	@DataField
	private Button submitButton;
	
	@Inject
	@DataField
	private Button cancelButton;

	@Inject
	@DataField
	private TextArea username;

	@Inject
	@DataField
	private TextArea email;

    @Inject
    @DataField
    private Label responseLabel;

    @PostConstruct
	public void initWidget() {		
	}

	@EventHandler("submitButton")
	private void handleSubmitEvent(ClickEvent event) {

        User tmp = new User();
        tmp.setEmail(email.getText());
        tmp.setUserName(username.getText());

        ErrorCallback<Message> errorCallback = new ErrorCallback<Message>() {

            @Override
            public boolean error(Message message, Throwable throwable) {
                responseLabel.setText(throwable.toString());
                return false;
            }
        };

        userService.call(new RemoteCallback<Boolean>() {

            @Override
            public void callback(Boolean response) {
                if (response) {
                    responseLabel.setText("Succesfully registered new Account!");
                } else {
                    responseLabel.setText("Unable to register your Account!");
                }
            }
        }, errorCallback).registerNewUser(tmp);
	}
	
	@EventHandler("cancelButton")
	private void handleCancelEvent(ClickEvent event){
		email.setText("");
		username.setText("");
	}
}
