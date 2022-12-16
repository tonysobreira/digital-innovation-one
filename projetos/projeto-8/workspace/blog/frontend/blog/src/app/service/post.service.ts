import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from '../model/Post';
import { Comment } from '../model/Comment';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  findAllPosts() {
    return this.http.get('http://localhost:3000/posts?_embed=comments')
  }

  savePost(post: Post) {
    post.createdAt = new Date();
    post.author = 'author ' + Math.floor(Math.random() * 3);

    return this.http.post('http://localhost:3000/posts', post)
  }

  deletePost(id: any) {
    return this.http.delete(`http://localhost:3000/posts/${id}`)
  }

  findPostsByAuthor(author: string) {
    return this.http.get(`http://localhost:3000/posts?_embed=comments&author_like=${author}`);
  }


  saveComment(comment: Comment) {
    comment.createdAt = new Date();
    return this.http.post('http://localhost:3000/comments', comment);
  }

  deleteComment(id: any) {
    return this.http.delete(`http://localhost:3000/comments/${id}`)
  }



}
