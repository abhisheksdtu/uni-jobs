package com.project.unijobs.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMPTZ")
    private Instant createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMPTZ")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }
}
