package es.pjd.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import es.pjd.R;

public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView eventDate;
    TextView eventTitle;
    int id;
    Context context;


    public EventViewHolder(View view) {
        super(view);
        CardView cardView = view.findViewById(R.id.cardEvent);

        cardView.setCardElevation(0);
        cardView.setCardBackgroundColor(view.getResources().getColor(R.color.white,null));
        cardView.setOnClickListener(this);

        eventDate = view.findViewById(R.id.eventDate);
        eventTitle = view.findViewById(R.id.eventTitle);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(context,  null);
        intent.putExtra("ID", id);

        context.startActivity(intent);

    }
}
