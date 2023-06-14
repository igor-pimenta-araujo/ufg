<?php

namespace App\Http\Livewire;

use Livewire\Component;
use App\Service\PostService;
use App\Service\UserService;
use App\Service\GeneralService;

class Postform extends Component
{
    public $title;
    public $content;
    public $idUser;
    public $users = [];
    public $success = false;

    protected $rules = [
        'title' => 'required|min:4|max:255',
        'content' => 'required|min:6|max:255',
        'idUser' => 'required|integer|exists:users,id',
    ];

    public function submit()
    {
        $this->validate();
        GeneralService::create(
            'post',
            [
                'title' => $this->title,
                'content' => $this->content,
                'idUser' => $this->idUser,
            ]
        );
        $this->success = true;
    }

    public function render()
    {
        $this->users = GeneralService::all('user');
        return view('livewire.post-form');
    }
}
