/**
 * Creating a sidebar enables you to:
 - create an ordered group of docs
 - render a sidebar for each doc of that group
 - provide next/previous navigation

 The sidebars can be generated from the filesystem, or explicitly defined here.

 Create as many sidebars as you want.
 */

module.exports = {
	mySidebar: [
		{
			type: 'category',
			label: 'はじめに',
			items: [
				'my-home',
				{
					type: 'category',
					label: 'GIT',
					items: [
						'gitstudy/cmd-collection',
					],
				},
				{
					type: 'category',
					label: 'SPRING BOOT',
					items: [
						'springboot/spring-boot-setting',
					],
				},
				{
					type: 'category',
					label: 'CI/CD',
					items: [
						'cicd/cicd-setting',
					],
				}
			],
		},
		{
			type: 'category',
			label: 'コンテンツ',
			items: [
				'content/introduction-docusaurus',
				'content/create-docusaurus',
			],
		},
	],
};
