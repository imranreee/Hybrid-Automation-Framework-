package repository.remote_repo.response_repo;

public class EmployeeRegPostRespModel {

    /**
     * name : morpheus
     * job : leader
     * id : 366
     * createdAt : 2023-05-19T10:09:08.796Z
     */

    private String name;
    private String job;
    private String id;
    private String createdAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
