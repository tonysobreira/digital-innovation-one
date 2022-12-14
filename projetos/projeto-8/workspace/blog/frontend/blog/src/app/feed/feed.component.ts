import { Component, OnInit } from '@angular/core';
import { PostService } from '../service/post.service';
import { Post } from '../model/Post';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  listPost: Post[];
  post: Post;
  nome: string;

  constructor(private postService: PostService) {
    this.listPost = [];
    this.post = new Post;
    this.nome = '';
  }

  ngOnInit(): void {
    this.findPosts();
  }

  findPosts() {
    this.postService.getPosts().subscribe((data: any) => {
      this.listPost = data;
    })
  }

  cadastrarMensagem() {
    this.postService.postMensagem(this.post).subscribe((data: any) => {
      //this.post = data;
      //location.assign('/feed');
      this.post = new Post;
      this.findPosts();
    })
  }

  apagarMensagem(id: any) {
    this.postService.deleteMensagem(id).subscribe((data: any) => {
      this.post = data;
      this.findPosts();
    })
  }

  findPostsByNome() {
    this.postService.findPostsByNome(this.nome).subscribe((data: any) => {
      this.listPost = data;
    })
  }

}
