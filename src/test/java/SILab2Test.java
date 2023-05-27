import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchTest() {

        User usr = new User(null,"jakov.damjanski@gmail.com","jakov.damjanski@gmail.com");
        List<User> usrlst = new ArrayList<>();

        //TestCase 1 from README.md
        //null user exception (with exception test)
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class , () -> SILab2.function(null,null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //Test Case 2 from README.md
        //password with space
        usr = new User(null,"jakov 1234","jakov.damjanski@gmail.com");
        assertFalse(SILab2.function(usr, usrlst));



        //Test Case 3 from README.md
        //non empty user list (user with same e-mail same username)
        //non empty user list  (different e-mail different username)
        usrlst.add(new User("jakov","mamamia@123","placeholder@mail.com"));
        usrlst.add(new User("not-jakov","mamamia@123","not-placeholder@mail.com"));

        usr = new User("jakov","mamamia123","placeholder@mail.com");

        assertFalse(SILab2.function(usr, usrlst));


        //Test Case 4 from README.md
        //short password + invalid email
        usr = new User(null,"jakov","jakovdamjanskigmailcom");
        usrlst = new ArrayList<>();

        assertFalse(SILab2.function(usr, usrlst));

        //Test Case 4 from README.md
        //everything valid end on T
        usrlst.add(new User("jakov","mamamia@123","placeholder@mail.com"));
        usrlst.add(new User("not-jakov","mamamia@123","not-placeholder@mail.com"));

        usr = new User("jakov","mamamia*123","placeholder@mail.com");

        assertFalse(SILab2.function(usr, usrlst));
    }

    @Test
    void everyConditionTest(){

        RuntimeException ex;

        //DONT_CARE values don't matter for the test
        //This is 2. case from the README.md
        ex = assertThrows(RuntimeException.class , () -> SILab2.function(new User("DONT_CARE",null,"DONT_CARE"),null));
        //We add the line bellow to differentiate among different runtime errors
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //3. from README.md
        ex = assertThrows(RuntimeException.class , () -> SILab2.function(new User("DONT_CARE","DONT_CARE",null),null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));




        //DISCLAIMER : The last wo cases are covered in the every branch test, here athey are duplicated.

        //1. from README.md
        ex = assertThrows(RuntimeException.class , () -> SILab2.function(null,null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //4. from README.md
        assertFalse(SILab2.function(new User("Random","Random","Random"),null));



    }
}