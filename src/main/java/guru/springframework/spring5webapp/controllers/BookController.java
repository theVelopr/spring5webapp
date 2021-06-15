package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        // when Spring gets a request to the URL slash books it is going to execute the getBooks method
        // and it's gonna provide that method a model(a model object), and the code is saying for that model
        // we are gonna add the attribute called 'books' and we are gonna get execute 'bookRepository'
        // which is gonna give us a list of books.
        // and Now, this model is gonna get return back to our view layer and it's gonna have an attribute 'books'
        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }
}
