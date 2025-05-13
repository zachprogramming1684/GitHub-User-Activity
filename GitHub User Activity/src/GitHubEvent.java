import java.util.List;

import com.google.gson.annotations.SerializedName;

import java.util.Date; 

public class GitHubEvent {
    private String id;
    private String type;
    private Actor actor;
    private Repo repo;
    private Payload payload;
    @SerializedName("public")
    private boolean isPublic; 
    private Date created_at;   

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Actor getActor() {
        return actor;
    }

    public Repo getRepo() {
        return repo;
    }

    public Payload getPayload() {
        return payload;
    }

    public boolean isPublic() { 
        return isPublic;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void setCreatedAt(Date createdAt) {
        this.created_at = createdAt;
    }
}

class Actor {
    private int id;
    private String login;
    private String display_login;
    private String gravatar_id;
    private String url;
    private String avatar_url;

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getDisplayLogin() {
        return display_login;
    }

    public String getGravatarId() {
        return gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setDisplayLogin(String displayLogin) {
        this.display_login = displayLogin;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatar_id = gravatarId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatar_url = avatarUrl;
    }
}

class Repo {
    private int id;
    private String name;
    private String url;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

class Payload {
    private int repository_id; 
    private long push_id;      
    private int size;
    private int distinct_size; 
    private String ref;
    private String head;
    private String before;
    private List<Commit> commits; 

    public int getRepositoryId() {
        return repository_id;
    }

    public long getPushId() {
        return push_id;
    }

    public int getSize() {
        return size;
    }

    public int getDistinctSize() {
        return distinct_size;
    }

    public String getRef() {
        return ref;
    }

    public String getHead() {
        return head;
    }

    public String getBefore() {
        return before;
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public void setRepositoryId(int repositoryId) {
        this.repository_id = repositoryId;
    }

    public void setPushId(long pushId) {
        this.push_id = pushId;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDistinctSize(int distinctSize) {
        this.distinct_size = distinctSize;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }
}

class Commit {
    private String sha;
    private CommitAuthor author; 
    private String message;
    private boolean distinct;
    private String url;

    public String getSha() {
        return sha;
    }

    public CommitAuthor getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public boolean isDistinct() { 
        return distinct;
    }

    public String getUrl() {
        return url;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public void setAuthor(CommitAuthor author) {
        this.author = author;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

class CommitAuthor {
    private String email;
    private String name;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}