<form wire:submit.prevent="submit">
    <input type="text" class="w-full px-4 py-3 rounded-lg shadow-sm focus:outline-none focus:shadow-outline text-gray-600 font-medium" wire:model="name" placeholder="Name"><br>
    @error('name') <span class="error">{{ $message }}</span> @enderror<br>
    <input type="text" class="w-full px-4 py-3 rounded-lg shadow-sm focus:outline-none focus:shadow-outline text-gray-600 font-medium" wire:model="email" placeholder="Email"><br>
    @error('email') <span class="error">{{ $message }}</span> @enderror<br>
    <button class="bg-sky-500 hover:bg-sky-700 px-5 py-2 text-sm leading-5 rounded-full font-semibold text-white" type="submit">Save User</button>
</form>