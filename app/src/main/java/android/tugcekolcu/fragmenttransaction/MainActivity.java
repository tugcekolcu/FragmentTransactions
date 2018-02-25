package android.tugcekolcu.fragmenttransaction;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {


    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getFragmentManager();
    }

    public void addA(View v) {

        FragmentA f1 = new FragmentA();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.layoutFragment, f1, "A");
        ft.commit();

    }

    public void addB(View v) {

        FragmentB f2 = new FragmentB();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.layoutFragment, f2, "B");
        ft.commit();

    }

    public void removeA(View v) {

        FragmentA f1 = (FragmentA) fm.findFragmentByTag("A");
        FragmentTransaction ft = fm.beginTransaction();
        if (f1 != null) {
            ft.remove(f1);
            ft.commit();
        } else {
            Toast.makeText(this, "Olmayan seyi yok edemezsin", Toast.LENGTH_LONG).show();
        }
    }

    public void removeB(View v) {

        FragmentB f2 = (FragmentB) fm.findFragmentByTag("B");
        FragmentTransaction ft = fm.beginTransaction();
        if (f2 != null) {
            ft.remove(f2);
            ft.commit();
        } else {
            Toast.makeText(this, "Olmayan seyi yok edemezsin", Toast.LENGTH_LONG).show();
        }
    }

    public void replaceAtoB(View v) {

        FragmentB fragmentB = new FragmentB();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.layoutFragment, fragmentB, "B");
        ft.commit();
    }


    public void replaceBtoA(View v) {

        FragmentA fragmentA = new FragmentA();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.layoutFragment, fragmentA, "A");
        ft.commit();
    }

    public void attachA(View v) {

        //Ekranda A tipinde fragment var. ama gorunur degilse

        FragmentA fragmentA = (FragmentA) fm.findFragmentByTag("A");
        FragmentTransaction ft = fm.beginTransaction();
        if (fragmentA != null) {

            ft.attach(fragmentA);
            ft.commit();

        }
        else{
            Toast.makeText(this, "Olmayan seyi detach edemezsin", Toast.LENGTH_LONG).show();

        }

    }
    public void detachA(View v) {

        FragmentA fragmentA = (FragmentA) fm.findFragmentByTag("A");
        FragmentTransaction ft = fm.beginTransaction();
        if (fragmentA != null) {

            ft.detach(fragmentA);
            ft.commit();

        }
        else{
            Toast.makeText(this, "Olmayan seyi detach edemezsin", Toast.LENGTH_LONG).show();
        }

    }


}
