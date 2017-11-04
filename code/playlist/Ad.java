package entity;

/**
 * Created by free_ion on 2017/6/23.
 */
public class Ad {
    private int no;
    private String adName;
    private Integer freq;

    public Ad(int no, String adName, Integer freq) {
        this.no = no;
        this.adName = adName;
        this.freq = freq;
    }

    public Ad(Ad ad) {
        this.no = ad.no;
        this.adName = ad.adName;
        this.freq = ad.freq;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    @Override
    public String toString() {
        return getAdName() + "\t" + getFreq();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(obj instanceof Ad) {
            Ad ad = (Ad) obj;
            if(ad.getAdName().equals(this.adName)) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return adName.hashCode();
    }
}
