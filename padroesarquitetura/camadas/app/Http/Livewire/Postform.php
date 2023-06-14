<?php

namespace App\Http\Livewire;

use Livewire\Component;
use App\Service\PostService;
use App\Service\UserService;

class Postform extends Component
{
    public $title;
    public $content;
    public $idUser;
    public $users = [];
 
    protected $rules = [
        'title' => 'required|min:4|max:255',
        'content' => 'required|min:6|max:255',
        'idUser' => 'required|integer|exists:users,id',
    ];
 
    public function submit()
    {
        $this->validate();
        PostService::create([
            'title' => $this->title,
            'content' => $this->content,
            'idUser' => $this->idUser,
        ]);
    }

    public function render()
    {
        $this->users = UserService::all();
        return view('livewire.post-form');
    }
}
