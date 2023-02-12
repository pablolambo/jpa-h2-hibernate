package com.example.demoRESTweb.service;

import com.example.demoRESTweb.entity.Address;
import com.example.demoRESTweb.entity.Student;
import com.example.demoRESTweb.repository.AddressRepository;
import com.example.demoRESTweb.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;

    public StudentService(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    public Student addStudent(Student student, Address address) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with id " + id + " doesn't exist."));
    }

    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public Address addAddressToStudent(Long studentId, Address address){
        Student student = getStudentById(studentId);
        address.setStudent(student.getId());
        return addressRepository.save(address);
    }

    public List<Address> getAddressesListByIdForStudent(Long studentId){
        Student student = getStudentById(studentId);
        return student.getStudent().getAddress();
    }


}
