/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retocinco.repository;

import co.edu.usa.ciclo4.retocinco.model.User;
import co.edu.usa.ciclo4.retocinco.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angélica Alzate
 */
@Repository
public class UserRepository {

    /**
     * Variable para instanciar el repositorio
     */
    @Autowired
    private UserCrudRepository userCrudRepository;

    
    /**
     * Método para retornar una lista de usuarios a partir del repositorio
     *
     * @return Lista de usuarios desde el repositorio
     */
    public List<User> getAll() {
        return userCrudRepository.findAll();
    }

    
    /**
     * Método para obtener un usuario a partir del repositorio
     *
     * @param id: id del usuario
     * @return un usuario a partir del repositorio
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    
    /**
     * Método para crear un usuario a partir del repositorio
     *
     * @param user: atributos del usuario
     * @return
     */

    public User save(User user) {
        return userCrudRepository.save(user);
    }

   /**
     * Método para validar si un correo existe o no
     *
     * @param email: correo a validar
     * @return un booleano que indica si el correo existe o no a partir del repo
     */
    public boolean emailExist(String email) {
        Optional<User> user = userCrudRepository.findByEmail(email);
        return user.isPresent();
    }

    /**
     * Método para obtener un usuario cuyo email y password coincidan
     *
     * @param email: correo del usuario
     * @param password: contraseña del usuario
     * @return el usuario cuya combinación de email y password coinciden
     */
    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /**
     * Método para borrar un usuario
     *
     * @param userId: id del usuario a eliminar
     * @return un booleano de usuario eliminado o no
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    
    /**
     * Método para obtener el último id
     * @return el id en forma descendente
     */
    
    
    public Optional<User> lastUserId() {
        return userCrudRepository.findTopByOrderByIdDesc();
    }
    
    public List<User> getUsersByMonth(String mes){
        return userCrudRepository.findByMonthBirthtDay(mes);
    }
}
