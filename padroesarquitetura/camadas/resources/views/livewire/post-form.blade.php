<form wire:submit.prevent="submit">
    <input type="text" class="w-full px-4 py-3 rounded-lg shadow-sm focus:outline-none focus:shadow-outline text-gray-600 font-medium" wire:model="title" placeholder="Title"><br>
    @error('title') <span class="error">{{ $message }}</span> @enderror<br>
    <input type="text" class="w-full px-4 py-3 rounded-lg shadow-sm focus:outline-none focus:shadow-outline text-gray-600 font-medium" wire:model="content" placeholder="Content"><br>
    @error('content') <span class="error">{{ $message }}</span> @enderror<br>
    <select class="appearance-none w-full py-1 px-2 bg-white rounded-lg" wire:model="idUser">
        @foreach ($users as $user)
        <option value="{{ $user['id'] }}">{{ $user['name'] }}</option>
        @endforeach
    </select>
    @error('idUser') <span class="error">{{ $message }}</span> @enderror<br>
    <button wire:click="submit" class="bg-sky-500 hover:bg-sky-700 px-5 py-2 text-sm leading-5 rounded-full font-semibold text-white mt-6" type="submit">Save Post</button>
</form>
