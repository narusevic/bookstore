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
@Table(name = "Writer")
@NamedQueries({
    @NamedQuery(name = "Writer.findAll", query = "SELECT w FROM Writer w"),
    @NamedQuery(name = "Writer.findById", query = "SELECT w FROM Writer w WHERE w.id = :id"),
    @NamedQuery(name = "Writer.findByFirstName", query = "SELECT w FROM Writer w WHERE w.firstName = :firstName"),
    @NamedQuery(name = "Writer.findByLastName", query = "SELECT w FROM Writer w WHERE w.lastName = :lastName")
})
@Getter
@Setter
@EqualsAndHashCode(of = "firstName")
@ToString(of = {"id", "firstName", "lastName"})
public class Writer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(min = 4, max = 50)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(min = 4, max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;

    @ManyToMany(mappedBy = "writerList")
    private List<Bookstore> bookstoreList = new ArrayList<>();
}
