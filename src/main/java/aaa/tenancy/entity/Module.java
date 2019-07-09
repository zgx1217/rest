package aaa.tenancy.entity;

import java.util.List;

public class Module {
    private Integer id;
    private String name;
    private Integer level_;
    private String url;
    private String permit;
    private Module parent;
    private List<Module> children;

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel_() {
        return level_;
    }

    public void setLevel_(Integer level_) {
        this.level_ = level_;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Module getParent() {
        return parent;
    }

    public void setParent(Module parent) {
        this.parent = parent;
    }

    public List<Module> getChildren() {
        return children;
    }

    public void setChildren(List<Module> children) {
        this.children = children;
    }
}
