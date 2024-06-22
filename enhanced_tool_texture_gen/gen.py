# Automatically generates enhanced version of swords, pickaxes, axes, shovels and hoes

import glob
import os

from PIL import Image

overlays = {
    "overlay_sword": Image.open("overlay/sword.png"),
    "overlay_pickaxe": Image.open("overlay/pickaxe.png"),
    "overlay_axe": Image.open("overlay/axe.png"),
    "overlay_shovel": Image.open("overlay/shovel.png"),
    "overlay_hoe": Image.open("overlay/hoe.png")
}

def unload_overlay_images():
    for _, overlay in overlays.items():
        overlay.close()

def find_images_in_folder(folder_name):
    return glob.glob(folder_name + "/*.png")

def combine_images_of_folder(folder_name, overlay_name):
    print("Doing folder: " + folder_name + " with overlay: " + overlay_name)

    for file in find_images_in_folder(folder_name):
        print("Overlaying file: " + file)

        base_image = Image.open(file)
        converted_image = base_image.convert("RGBA")

        overlay = overlays["overlay_" + overlay_name]

        if overlay != None:
            print("Copying file: " + file)

            base_image_copy = converted_image.copy()
            base_image_copy.paste(overlay, (0, 0), overlay)
            base_image_copy.save("copper_" + os.path.basename(file), base_image_copy.format)
            base_image_copy.close()
            base_image.close()

            print("Done with file: " + file)

def combine_images():
    combine_images_of_folder("base/sword", "sword")
    combine_images_of_folder("base/pickaxe", "pickaxe")
    combine_images_of_folder("base/axe", "axe")
    combine_images_of_folder("base/shovel", "shovel")
    combine_images_of_folder("base/hoe", "hoe")

if __name__ == "__main__":
    combine_images()
    unload_overlay_images()