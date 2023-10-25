package com.task.a.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.a.Entity.Drone;

public interface DroneRepo extends JpaRepository<Drone, Integer> {

}
