package es.pjd.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import es.pjd.R;
import es.pjd.data.model.Event;

public class RecyclerAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private List<Event> events;
    private Context context;
    DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

    public RecyclerAdapter(List<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_event, viewGroup, false);
        EventViewHolder viewHolder = new EventViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder viewHolder, int i) {

        viewHolder.eventDate.setText(formatter.format(events.get(i).getDate()));
        viewHolder.eventTitle.setText(events.get(i).getTitle());
        viewHolder.context = context;
        viewHolder.id = i;

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Event getEvent(int position){
        return events.get(position);
    }
}
