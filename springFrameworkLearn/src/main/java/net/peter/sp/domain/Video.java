package net.peter.sp.domain;


public class Video {

    private int id;

    private String title;



    public Video(){

    }

    public Video(String title, int id){
        System.out.println("Video 带参数构造函数");
        this.title = title;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        System.out.println("Video的getTitle方法被调用");
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
