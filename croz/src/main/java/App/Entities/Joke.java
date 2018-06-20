package App.Entities;


import javax.persistence.*;

@Entity
@Table(name = "joke")
public class Joke implements Comparable<Joke>{

    @Column(name = "id", nullable = false)
    private int id;
    @Id
    @Column(name="content", nullable = false)
    private String content;
    @Column(name= "likes", nullable = false)
    private int likes = 0;
    @Column(name = "dislikes", nullable = false)
    private int dislikes = 0;

    public Joke like(){
        this.setLikes(this.getLikes()+1);
        return this;
    }

    public Joke dislike(){
        this.setDislikes(this.getDislikes()+1);
        return this;
    }

    public Joke() {
    }

    public Joke(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return "id: " + id + ", content:" + content + ", likes: " + likes + ", dislikes: " + dislikes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public int compareTo(Joke joke) {
        if(((joke.getLikes()-joke.getDislikes()) - (this.getLikes()-this.getDislikes())) == 0){
            return joke.getLikes()-this.getLikes();
        }
        return (joke.getLikes()-joke.getDislikes()) - (this.getLikes()-this.getDislikes());
    }
}
