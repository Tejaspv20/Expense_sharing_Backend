package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "group_id")   // foreign key in expense table
    @JsonIgnoreProperties({"expenses", "members"}) // prevent circular JSON
    private Group group;  // link to group

    @ManyToOne
    @JoinColumn(name = "paid_by_id") // foreign key for user
    @JsonIgnoreProperties({"password"}) // don’t send password
    private User paidBy;

    // Constructors
    public Expense() {}

    public Expense(String description, Double amount, Group group, User paidBy) {
        this.description = description;
        this.amount = amount;
        this.group = group;
        this.paidBy = paidBy;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public Group getGroup() { return group; }
    public void setGroup(Group group) { this.group = group; }

    public User getPaidBy() { return paidBy; }
    public void setPaidBy(User paidBy) { this.paidBy = paidBy; }
}
