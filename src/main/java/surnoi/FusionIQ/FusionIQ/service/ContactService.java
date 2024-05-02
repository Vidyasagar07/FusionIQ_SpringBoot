package surnoi.FusionIQ.FusionIQ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import surnoi.FusionIQ.FusionIQ.data.Contact;
import surnoi.FusionIQ.FusionIQ.exception.UserNotFoundException;
import surnoi.FusionIQ.FusionIQ.repo.ContactRepository;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    @Autowired
    public ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }
    public Contact save(Contact contact){
        return contactRepository.save(contact);
    }
    public Contact findContactById(Long id){
        return contactRepository.findContactById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
    public List<Contact> findAllContacts(){
        return contactRepository.findAll();
    }
    public Contact save(String firstName, String lastName, String email, String message, String category){
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setEmail(email);
        contact.setMessage(message);
        contact.setCategory(category);
        return contactRepository.save(contact);
    }

}
