package com.example.test_project.base

interface EventHandler<T> {
  fun obtainEvent(event: T)
}