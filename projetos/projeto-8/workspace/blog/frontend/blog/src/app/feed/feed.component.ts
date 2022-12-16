import { Component, OnInit } from '@angular/core';
import { PostService } from '../service/post.service';
import { Post } from '../model/Post';
import { Comment } from '../model/Comment';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  postList: Post[];
  post: Post;
  author: string;
  comment: Comment;
  newCommentText: string;

  constructor(private postService: PostService) {
    this.postList = [];
    this.post = new Post;
    this.author = '';
    this.comment = new Comment;
    this.newCommentText = '';
  }

  ngOnInit(): void {
    this.findAllPosts();
  }

  findAllPosts() {
    this.postService.findAllPosts().subscribe((data: any) => {
      this.postList = data;
    })
  }

  findPostsByAuthor() {
    this.postService.findPostsByAuthor(this.author).subscribe((data: any) => {
      this.postList = data;
    })
  }

  savePost() {
    this.postService.savePost(this.post).subscribe((data: any) => {
      //this.post = data;
      //location.assign('/feed');
      this.post = new Post;
      this.findAllPosts();
    })
  }

  deletePost(id: any) {
    this.postService.deletePost(id).subscribe((data: any) => {
      //this.post = data;
      this.findAllPosts();
    })
  }

  postComment(id: any) {
    this.comment.body = this.newCommentText;
    this.comment.postId = id;

    this.postService.saveComment(this.comment).subscribe((data: any) => {
      this.findAllPosts();
      this.newCommentText = '';
    })
  }

  deleteComment(id: any) {
    this.postService.deleteComment(id).subscribe((data: any) => {
      this.findAllPosts();
    })
  }




}
