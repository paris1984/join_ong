package es.pjd.viewmodel;

import com.google.firebase.firestore.FirebaseFirestore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class UserViewModelTest {



    @Test
    public void checkDBClass(){
        FirebaseFirestore firebaseFirestore = mock(FirebaseFirestore.class);
        UserViewModel userViewModel = new UserViewModel(firebaseFirestore);

        assertEquals(FirebaseFirestore.class, userViewModel.getDB().getClass());
    }

}