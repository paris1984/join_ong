package es.pjd.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.pjd.data.model.Event;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Event>> events;

    public HomeViewModel() {
        events = new MutableLiveData<>();
        List<Event> eventsCreate = new ArrayList<>();
        eventsCreate.add(new Event(new Date(),"Visita a la paz"));
        eventsCreate.add(new Event(new Date(),"Visita a la paz 2"));
        eventsCreate.add(new Event(new Date(),"Visita a la paz"));
        eventsCreate.add(new Event(new Date(),"Visita a la paz 2"));eventsCreate.add(new Event(new Date(),"Visita a la paz"));
        eventsCreate.add(new Event(new Date(),"Visita a la paz 2"));eventsCreate.add(new Event(new Date(),"Visita a la paz"));
        eventsCreate.add(new Event(new Date(),"Visita a la paz 2"));eventsCreate.add(new Event(new Date(),"Visita a la paz"));
        eventsCreate.add(new Event(new Date(),"Visita a la paz 2"));eventsCreate.add(new Event(new Date(),"Visita a la paz"));
        eventsCreate.add(new Event(new Date(),"Visita a la paz 2"));eventsCreate.add(new Event(new Date(),"Visita a la paz"));
        eventsCreate.add(new Event(new Date(),"Visita a la paz 2"));eventsCreate.add(new Event(new Date(),"Visita a la paz"));
        eventsCreate.add(new Event(new Date(),"Visita a la paz 2"));eventsCreate.add(new Event(new Date(),"Visita a la paz"));
        eventsCreate.add(new Event(new Date(),"Visita a la paz 2"));
        events.setValue(eventsCreate);
    }

    public LiveData<List<Event>> getEvents() {
        return events;
    }
}