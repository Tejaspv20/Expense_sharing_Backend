package com.example.demo.repository;
import com.example.demo.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Correct way to access groupId inside expense
    List<Expense> findByGroup_Id(Long groupId);
}
