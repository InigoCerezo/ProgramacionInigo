package Tema4.POO1.Ejercicio1;

public class Reloj {
    public static final int hoursDef = 0, minsDef = 0, secsDef = 0;
    private boolean militTime = true;
    private int h, m, s;
    public Reloj(){
        this.h = hoursDef;
        this.m = minsDef;
        this.s = secsDef;
    }
    public Reloj(int h, int m, int s){
        if(h<24 && h>=0){
            setH(h);
        }
        if(m<60 && m>=0){
            setM(m);
        }
        if(s<60 && s>=0){
            setS(s);
        }
    }

    public void setMilitTime(boolean militTime) {
        this.militTime = militTime;
    }
    public String toStringu(){
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
        this.h = h;
    }
    public void setM(int m) {
        this.m = m;
    }
    public void setS(int s) {
        this.s = s;
    }

}
