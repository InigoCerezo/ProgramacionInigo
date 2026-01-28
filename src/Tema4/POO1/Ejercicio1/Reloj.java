package Tema4.POO1.Ejercicio1;

public class Reloj {
    public static final int HOURS_DEF = 0, MINS_DEF = 0, SECS_DEF = 0;
    private boolean militTime = true;
    private int h, m, s;

    public Reloj(){
        this.h = HOURS_DEF;
        this.m = MINS_DEF;
        this.s = SECS_DEF;
    }

    public Reloj(int h, int m, int s){
        setH(h);
        setM(m);
        setS(s);
        //IFS EN LOS SETTERS
    }

    public void setMilitTime(boolean militTime) {
        this.militTime = militTime;
    }
    public String toString(){
        if (militTime){
            return String.format("%02d:%02d:%02d",h, m, s);
        }else{
            if (h>12){
                String pm = "PM";
                return String.format("%02d:%02d:%02d, %s",(h-12), m, s, pm);
            } else if (h == 12) {
                String pm = "PM";
                return String.format("%02d:%02d:%02d, %s",h, m, s, pm);
            } else{
                String am = "AM";
                return String.format("%02d:%02d:%02d, %s",h, m, s, am);
            }
        }
    }
    public int getH(){
        return h;
    }
    public int getM() {
        return m;
    }
    public int getS() {
        return s;
    }
    public void setH(int h) {
        if(h<24 && h>=0) {
            this.h = h;
        }
    }
    public void setM(int m) {
        if(m<60 && m>=0){
            this.m = m;
        }
    }
    public void setS(int s) {
        if(s<60 && s>=0){
            this.s = s;
        }
    }

}
