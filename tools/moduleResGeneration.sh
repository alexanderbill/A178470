#!/bin/bash -

# 模块目录生成脚本
# 用法：第一个参数为模块的名称，然后自动创建模块的目录(以下所有目录)
# ex: A178470 git:(master) ✗ ./tools/moduleResGeneration.sh app/src/main/res_module/me
# mkdir: app/src/main/res_module/me: File exists  (即表示创建成功)
# 创建之后必须sync一下才会生效。


basePath=$1

mkdir $basePath
mkdir $basePath/anim
mkdir $basePath/animator
mkdir $basePath/drawable
mkdir $basePath/drawable-hdpi
mkdir $basePath/drawable-xhdpi
mkdir $basePath/drawable-xxhdpi
mkdir $basePath/layout
mkdir $basePath/values

