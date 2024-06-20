package br.ufrn.imd.ITHelper.service;

import br.ufrn.imd.ITHelper.dto.EmployeeDTO;
import br.ufrn.imd.ITHelper.dto.TicketDTO;
import br.ufrn.imd.ITHelper.model.Employee;
import br.ufrn.imd.ITHelper.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    public EmployeeDTO getFuncionarioByIdUser(Integer id){
        Employee employee = employeeRepository.findByUsuarioId(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if(employee != null){
            employeeDTO.setIdFuncionario(employee.getIdFuncionario());
            employeeDTO.setCargoFuncionario(employee.getCargoFuncionario());
            employeeDTO.setIdDepartamento(employee.getDepartamento().getIdDepartamento());
            employeeDTO.setIdUsuario(employee.getUsuario().getId());
            employeeDTO.setNomeDepartamento(employee.getDepartamento().getNomeDepartamento());
        }
        return employeeDTO;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);

        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();

            // Atualizar os campos necessários
            existingEmployee.setCargoFuncionario(updatedEmployee.getCargoFuncionario());
            existingEmployee.setDepartamento(updatedEmployee.getDepartamento());
            // Adicione outros campos conforme necessário

            return employeeRepository.save(existingEmployee);
        } else {
            return null;
        }
    }

    public boolean deleteFuncionario(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}

