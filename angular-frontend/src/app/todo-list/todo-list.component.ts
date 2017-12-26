import { Component, OnInit } from '@angular/core';
import {Todo } from '../todo';
import {NgForm } from '@angular/forms';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  todos: Todo[];
  newTodo: Todo = new Todo();
  editing: boolean;
  editingTodo: Todo = new Todo();

  constructor() { }

  ngOnInit() {
    this.getTodos();
  }

  getTodos(): void {

  }

  createTodo(todoForm: NgForm): void {

  }

  deleteTodo(id: string): void {

  }

  updateTodo(todoData: Todo): void {

  }

  toggleCompleted(todoData: Todo): void {

  }

  editTodo(todoData: Todo): void {

  }

  clearEditing(): void {

  }

}
