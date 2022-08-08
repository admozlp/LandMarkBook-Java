package com.ademozalp.landmarkbookjava;

public class Singleton
{//intant yöntemi ile büyük verileri gönderemiyoruz bü yüzden singleton tekniği kullanılır. singleton sınıfından tek bir nesne üretilebilir ve buna her yerden ulaşılabilir.
    private Landmark sentLandmark;
    private static Singleton singleton;

    public Landmark getSentLandmark()
    {
        return sentLandmark;
    }
    public void setSentLandmark(Landmark sentLandmark)
    {
        this.sentLandmark = sentLandmark;
    }

    public static Singleton getInstance()
    {
        if(singleton == null)
            singleton = new Singleton();
        return singleton;
    }
}
