/*
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Message;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class GmailOAuth2Example {

    private static final String APPLICATION_NAME = "My Gmail Application";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FILE_PATH = "path/to/credentials.json";
    private static final String TOKENS_DIRECTORY_PATH = "path/to/tokens_directory";

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        // Carga las credenciales de OAuth 2.0 desde el archivo JSON
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(
                GmailOAuth2Example.class.getResourceAsStream(CREDENTIALS_FILE_PATH)));

        // Crea el flujo de autorización
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        AuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, JSON_FACTORY, clientSecrets, Collections.singleton(GmailScopes.GMAIL_SEND))
                .setDataStoreFactory(new StoredCredentialDataStoreFactory(TOKENS_DIRECTORY_PATH))
                .setAccessType("offline")
                .build();

        // Obtén la autorización del usuario
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())
                .authorize("user");

        // Crea una instancia de Gmail utilizando las credenciales OAuth 2.0
        Gmail gmail = new Gmail.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

        // Código para enviar el correo electrónico
        String from = "from@example.com";
        String to = "to@example.com";
        String subject = "Subject";
        String body = "Message body";
        sendEmail(gmail, from, to, subject, body);
    }

    private static void sendEmail(Gmail service, String from, String to, String subject, String body) throws IOException {
        // Crear el mensaje
        Message message = createMessageWithEmail(createEmail(from, to, subject, body));

        // Enviar el mensaje
        service.users().messages().send("me", message).execute();
        System.out.println("Correo electrónico enviado correctamente.");
    }

    private static com.google.api.services.gmail.model.Message createMessageWithEmail(MimeMessage email)
            throws IOException, MessagingException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = Base64.getUrlEncoder().encodeToString(bytes);
        com.google.api.services.gmail.model.Message message = new com.google.api.services.gmail.model.Message();
        message.setRaw(encodedEmail);
        return message;
    }

    private static MimeMessage createEmail(String from, String to, String subject, String body)
            throws MessagingException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(from));
        email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
        email.setSubject(subject);
        email.setText(body);
        return email;
    }

    private static class StoredCredentialDataStoreFactory extends GoogleCredentialDataStoreFactory {

        public StoredCredentialDataStoreFactory(String tokensDirectoryPath) {
            super(tokensDirectoryPath);
        }

        @Override
        protected File getDataStoreFile() throws IOException {
            File dataStoreDir = new File(getDataStoreDirectoryPath());
            if (!dataStoreDir.exists() && !dataStoreDir.mkdirs()) {
                throw new IOException("Failed to create data store directory: " + getDataStoreDirectoryPath());
            }
            return new File(dataStoreDir, "StoredCredential");
        }
    }
}
*/