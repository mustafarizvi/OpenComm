package org.opencomm.chatclient;

import java.util.Collection;
import java.util.Iterator;

import org.opencomm.base.User;
import org.opencomm.base.UserList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView tv = new TextView(this);
        String[] att={"school"};
        String[] data={"Cornell"};
        User mbentz = new User("mbentz", att,data);
        User rnaka = new User("rnaka", att, data);
        UserList list = new UserList();
        try {
        	list.put(mbentz.getName(), mbentz);
        	list.put(rnaka.getName(), rnaka);
        }
        catch(Exception e) {}
        Collection <User> values = list.values();
        Iterator <User>itr = values.iterator();
        while(itr.hasNext()) {
        	tv.setText((String)(itr.next()).getData("school"));
        }
        setContentView(tv);

    }
}