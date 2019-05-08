/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOOKSTORE")
@NamedQueries({
    @NamedQuery(name = "Bookstore.findAll", query = "SELECT b FROM Bookstore b"),
    @NamedQuery(name = "Bookstore.findById", query = "SELECT b FROM Bookstore b WHERE b.id = :id"),
    @NamedQuery(name = "Bookstore.findByTitle", query = "SELECT b FROM Bookstore b WHERE b.title = :title")})
@Getter
@Setter
@EqualsAndHashCode(of = "title")
@ToString(of = {"id", "title", "city"})
public class Bookstore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;

    @Size(max = 50)
    @Column(name = "CITY")
    private String city;

    @ManyToMany(mappedBy = "bookstoreList")
    private List<Writer> writerList = new ArrayList<>();
}
