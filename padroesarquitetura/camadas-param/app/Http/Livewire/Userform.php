<?php

namespace App\Http\Livewire;

use Livewire\Component;
use App\Service\GeneralService;

class Userform extends Component
{
    public $name;
    public $email;

    protected $rules = [
        'name' => 'required|min:6|max:255',
        'email' => 'required|email|unique:users,email',
    ];

    public function submit()
    {
        $this->validate();
        GeneralService::create(
            'user',
            [
                'name' => $this->name,
                'email' => $this->email,
            ]
        );
        return redirect('/');
    }

    public function render()
    {
        return view('livewire.user');
    }
}
