package surnoi.FusionIQ.FusionIQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import surnoi.FusionIQ.FusionIQ.data.Contact;
import surnoi.FusionIQ.FusionIQ.service.ContactService;
import surnoi.FusionIQ.FusionIQ.service.EmailSenderService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;
    @Autowired
    private EmailSenderService emailSenderService;
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }
//    @PostMapping("/contacts")
//    public Contact addContact(@RequestBody Contact contact) {
//        return contactService.save(contact);
//    }
    @GetMapping("/get/{id}")
    public Contact findContactById(@PathVariable ("id") long id) {
        return contactService.findContactById(id);
    }
    @GetMapping("/all")
    public List<Contact> findAllContacts(Contact contact){
        return contactService.findAllContacts();
    }
    @PostMapping("/add")
    public ResponseEntity<Contact> addContact(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("message") String message, @RequestParam("category") String category) throws IOException {
        LocalDateTime currentDateAndTime = LocalDateTime.now();
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setEmail(email);
        contact.setMessage(message);
        contact.setCategory(category);
        contact.setDateTime(currentDateAndTime);

        contact = contactService.save(contact);

        sendRegistrationSuccessEmail(contact.getEmail(), contact.getFirstName());

        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }
    private void sendRegistrationSuccessEmail(String to, String first_name) {
        String subject = "Registration Successful";
        String body = "Dear " + first_name + ",\n\n" +
                "Thank you for registering with our system. Your account has been successfully created." + "\n\n" +
                "We appreciate your trust in us and look forward to serving you. If you have any questions or need assistance, please feel free to reach out to us. We will get back to you as soon as possible.\n\n" +
                "Best regards,\n" +
                "SURNOI TECHNOLOGY PRIVATE LIMITED";

          emailSenderService.sendEmail(to, subject, body);
    }

}
