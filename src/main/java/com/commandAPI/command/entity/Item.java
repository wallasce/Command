package com.commandAPI.command.entity;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = true)
    private String observation;

    @Column(nullable = false)
    private State state;

    public enum State {
        PREPARING,
        READY,
        DELIVERED
    }

    public Item() {
        this.state = State.PREPARING;
    }

    public Item(Product product, Integer quantity, String observation) {
        this.product = product;
        this.quantity = quantity;
        this.observation = observation;
        this.state = State.PREPARING;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<State> getStates() {
        return Arrays.asList(State.values());
    }
}
