package com.cat_back.model;

/**
 *
 * @author king3212
 */
public class Store {
    private Long id;
    private String name;
    private Long manager;

    // 构造方法
    public Store() {}

    public Store(Long id, String name, Long manager) {
        this.id = id;
        this.name = name;
        this.manager = manager;
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }

    // toString 方法，方便打印对象信息
    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}

